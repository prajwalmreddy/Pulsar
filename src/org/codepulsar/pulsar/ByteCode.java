package org.codepulsar.pulsar;

public enum ByteCode {
    // Operators,
    OP_NEGATE, OP_NOT, // Unary
    OP_ADD, OP_SUBTRACT, OP_MULTIPLY, OP_DIVIDE, // Binary
    OP_COMPARE_EQUAL, OP_GREATER, OP_LESSER, // Comparison
    OP_LOGICAL_OR, OP_LOGICAL_AND, // Logical

    // Data Types and Variables
    OP_CONSTANT,

    // Control Flow OpCodes
    OP_JUMP_IF_FALSE,

    // Special OpCodes
    OP_POP
}
