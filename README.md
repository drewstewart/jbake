# Getting Started

## Installation

1. Make sure you have Java 7+ JRE and that the `java` command is available in your path

2. Git clone this repository to your machine, this folder will be known as `JBAKE_HOME`

3. Open a command prompt and from `JBAKE_HOME` run `./bin/jbake - h` (or `jbake.bat -h` if you are on Windows) to confirm everything works, you should see usage help text

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
