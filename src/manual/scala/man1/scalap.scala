/* NSC -- new Scala compiler
 * Copyright 2005-2013 LAMP/EPFL
 * @author Stephane Micheloud
 */

package scala.man1

/**
 *  @author Stephane Micheloud
 */
object scalap extends Command {
  import _root_.scala.tools.docutil.ManPage._

  protected def cn = new Error().getStackTrace()(0).getClassName()

  val name = Section("NAME",

    MBold(command) & " " & NDash & " Scala class file decoder for the " &
    Link("Scala 2", "https://scala-lang.org/") & " language")

  val synopsis = Section("SYNOPSIS",

    CmdLine(" [ " & Argument("options") & " ] " & Argument("class name")))

  val parameters = Section("PARAMETERS",

    DefinitionList(
      Definition(
        Mono(Argument("options")),
        "Command line options. See " & Link(Bold("OPTIONS"), "#options") &
        " below."),
      Definition(
        Mono(Argument("class name")),
        "Full-qualified name of a class to be decoded (such as " &
        Mono("hello.HelloWorld") & ").")))

  val description = Section("DESCRIPTION",

    "The " & MBold(command) & " tool reads a class file generated by the" &
    "Scala compiler, and displays object and class definitions.",

    "By default, " & MBold(command) & " looks for the given class file " &
    "in the current directory. You can specify a separate classpath with " &
    CmdOption("classpath") & "(see " & Link(Bold("OPTIONS"), "#options") & ", below).")

  val options = Section("OPTIONS",

    "The decoder has a set of standard options that are supported on the " &
    "current development environment and will be supported in future releases.",

    Section("Standard Options",
      DefinitionList(
        Definition(
          CmdOption("help"),
          "Display this usage message."),
        Definition(
          CmdOption("private"),
          "Print private definitions."),
        Definition(
          CmdOption("verbose"),
          "Print out additional information."),
        Definition(
          CmdOption("version"),
          "Print product version and exit."),
        Definition(
          CmdOption("cp") & "| " & CmdOption("classpath"),
          "Specify where to find user class files."))))

  val examples = Section("EXAMPLES",

    DefinitionList(
      Definition(
        "Display definitions for a generated class file",
        CmdLine("hello.HelloWorld"))))

  val exitStatus = Section("EXIT STATUS",

    MBold(command) & " returns a zero exit status if it succeeds to process " &
    "the specified input files. Non zero is returned in case of failure.")

  override val authors = Section("AUTHOR",

    "Written by Ilya Sergey.")

  val seeAlso = Section("SEE ALSO",

    Link(Bold("fsc") & "(1)", "fsc.html") & ", " &
    Link(Bold("scala") & "(1)", "scala.html") & ", " &
    Link(Bold("scalac") & "(1)", "scalac.html") & ", " &
    Link(Bold("scaladoc") & "(1)", "scaladoc.html"))

  def manpage = new Document {
    title = command
    date = "June 2006"
    author = "Stephane Micheloud"
    version = "1.0"
    sections = List(
      name,
      synopsis,
      parameters,
      description,
      options,
      examples,
      exitStatus,
      authors,
      bugs,
      copyright,
      seeAlso)
  }
}
