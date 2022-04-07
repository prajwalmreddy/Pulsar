package temp.pulsar;

import temp.lang.CompilerError;
import temp.lang.Instruction;
import temp.lang.LocalVariable;
import temp.primitives.Primitive;
import temp.util.Disassembler;
import temp.util.ErrorReporter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Compiler {
    // Input Data
    private final String sourceCode;
    private ArrayList<Instruction> instructions;

    // Data To Help In Compiling To Assembly
    private LocalVariable locals;
    private ArrayList<Primitive> values;

    // Output Data
    private final PrintWriter pw;
    private CompilerError errors;
    private CompilerError staticErrors;

    public Compiler(String sourceCode) throws FileNotFoundException {
        this.sourceCode = sourceCode;

        this.pw = new PrintWriter(Pulsar.conditions.getFileIn() + ".asm");
    }

    public void init() {
        ByteCodeCompiler bcc = new ByteCodeCompiler(this.sourceCode);
        this.instructions = bcc.compileByteCode();
        this.locals = bcc.getLocals();

        this.errors = bcc.getErrors();
        this.staticErrors = bcc.getStaticErrors();

        this.values = bcc.getValues();

        ErrorReporter.report(this.errors, this.sourceCode);
        ErrorReporter.report(this.staticErrors, this.sourceCode);

        Disassembler.disassemble(this.instructions, bcc);

        compile();
        this.pw.close();
    }

    private void compile() {
        this.pw.println("");
    }
}
