title=FAQ
type=page
status=published
~~~~~~

### Why doesn't my document get rendered?

You're doing it wrong. So many reasons, have you:

- Got a valid metadata header at the beginning of your document?
- Set `type=interface-specification` and `status=published`?


### Why doesn't my <% include "somefile.md" %> work?

If the the included file doesn't exist, or the path to the file is invalid it will not be included and the `<% include "somefile.md" %>` tag will still be visible in your original document.

Included files are loaded relative to the path of the parent file. For example, if you have this structure:

```
.
| -- content
|    | -- introduction.md
|    | -- services
|         | -- manage-inventory.md
```

To include the contents of `introduction.md` in `manage-inventory.md` do:

`<% include "../introduction.md" %>`


