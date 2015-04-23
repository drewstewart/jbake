# Getting Started

## Installation

1. Make sure you have Java 7+ JRE and that the `java` command is available in your path

2. Git clone this repository to a folder on your machine, this folder will be known as `JBAKE_HOME`

3. Open a command prompt and from `JBAKE_HOME` run `./bin/jbake - h` (or `jbake.bat -h` if you are on Windows) to confirm everything works, you should see the usage help text:

```
Jbake v2.3.2 (2014-09-20 19:20) [http://jbake.org]

Usage: jbake...
```

## Generating iB2B documents

From `JBAKE_HOME` run the following commands:

```
$ ./bin/jbake ib2b-documentation
```

This will bake the ib2b documentation and placing the exported html in the `ib2b_documentation/output` folder by default. To view the documentation run JBake in server mode:

```
$ ./bin/jbake -s ib2b_documentation/output
```

You can preview the documentation in your browser at http://localhost:8820

## Everything else

Once you have the server running go see [Getting Started](http://localhost:8820/getting-started) and [FAQ](http://localhost:8820/faq) for details on how to add new specs, edit templates etc.

## Building this project

1. This is a maven project. Import it into your IDE (IntelliJ if you appreciate a real IDE, Eclipse if you dont').
2. Add `/lib/liqp-0.6.1.jar` as a project dependency. Its not hosted on maven central, you could add it to a local mavan repository but thats for you to google.
3. Make -> Run

## Updating the runtime

So you've made some changes to the src, everything compiles locally and you're ready to share with everyone else. The scripts in `/bin` load the jar `lib/jbake-core.jar`. You must export a jar with the same name to `/lib` from your IDE to update the runtime. All the lib dependencies are also stored in `/lib` so make sure you generate a manifest with the classpath set correctly to reference these dependencies (unpack the current jar and check out `META-INF/MANIFEST.MF` for an example if you get stuck).

Check in your both your src and the updated runtime.
