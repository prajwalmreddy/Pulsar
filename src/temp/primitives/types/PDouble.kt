package temp.primitives.types

import temp.primitives.Primitive

class PDouble(var value: Double) : Primitive() {
    override fun negate(): Primitive {
        return PDouble(-this.value)
    }

    override fun not(): Primitive {
        return PNone()
    }

    override fun toString(): String {
        return value.toString()
    }
}