### What does this project contain?
- The model classes
	- ... all of which are generated out of the `model/EttinBase.xcore`file.
- The only non-generated file in the source folder is `module-info.java`.


### Why is this project an Eclipse plugin?
Because I wanted to use XCore support, and the XCore editor plugin doesn't support plain Java projects for code generation.

**Note**: The project is built via Maven as standard Java project, however, because the generated EMF model classes can be used without Eclipse plugins, too.


