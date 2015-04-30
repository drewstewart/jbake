package org.jbake.template;

import com.orientechnologies.orient.core.record.impl.ODocument;
import groovy.lang.Writable;
import liqp.nodes.LNode;
import liqp.tags.Tag;
import org.apache.commons.configuration.CompositeConfiguration;
import org.jbake.app.ContentStore;
import liqp.Template;
import org.jbake.app.DocumentList;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

/**
 * Created by drew on 16/04/2015.
 */
public class LiquidTemplateEngine extends AbstractTemplateEngine {


    private final Map<String, Template> cachedTemplates = new HashMap<String, Template>();

    public LiquidTemplateEngine(CompositeConfiguration config, ContentStore db, File destination, File templatesPath) {
        super(config, db, destination, templatesPath);

        // register custom Include tag.
        Tag.registerTag(new Include(templatesPath));
    }

    class Include extends Tag {
        private File snippetsFolder;
        private String extension = ".liquid";

        Include(File templatesPath) {
            snippetsFolder = new File(templatesPath.getPath(), "partials");
        }

        public Object render(Map<String, Object> context, LNode... nodes) {

            try {
                String e = super.asString(nodes[0].render(context));
                Template include = Template.parse(new File(snippetsFolder, e + extension));
                if(nodes.length > 1) {
                    Object value = nodes[1].render(context);
                    context.put(e, value);
                }

                return include.render(context);
            } catch (Exception var6) {
                // TODO: log failed includes to console, generally means included partial has syntax error
                return "";
            }
        }
    }

    @Override
    public void renderDocument(Map<String, Object> model, String templateName, Writer writer) throws RenderingException {
        try {
            final Template template = getTemplate(templateName);

            // mixin extensions
            model = mixin(model);

            writer.write(template.render(model));
        } catch (Exception e) {
            throw new RenderingException(e);
        }
    }

    private Template getTemplate(final String templateName) throws ClassNotFoundException, IOException {

        final File templateFile = new File(templatesPath, templateName);
        Template template = cachedTemplates.get(templateName);

        if (template != null)
            return template;

        template = Template.parse(templateFile);
        cachedTemplates.put(templateName, template);

        return template;
    }

    private Map<String, Object> mixin(final Map<String, Object> model) {
        return new HashMap<String, Object>(model) {

            @Override
            public Object get(Object key) {
                if (key instanceof String) {
                    key = key.toString();

                    if ("published_date".equals(key)) {
                        return new Date();
                    }

                    if (((String)key).contains("published_")) {
                        String docType = ((String)key).substring("published_".length(), ((String)key).length()-1);
                        System.out.println("docType is" + docType);
                        return DocumentList.wrap(db.getPublishedContent(docType).iterator());
                    }
                }

                return super.get(key);
            }
        };
    }
}
