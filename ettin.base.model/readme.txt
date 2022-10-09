Q: Why is this project an Eclipse plugin?

A: Because I wanted to use XCore support, and the XCore editor plugin doesn't
   support plain Java projects for code generation.

Note: The project is built via Maven as standard Java project, however, because
      the generated EMF model classes can be used without Eclipse plugins, too.
