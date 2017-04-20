# TCOM
A simple parser of expresions with a, b, c and operators +, -, /, *, whith $ as end of line.
## Examples
**in**:
a$
a + b = c
a     +      b      + c     +a-   b/a    *   c < c$
a     +      b      + c     +a-   b/a    *   c < c    - a   / b    *  c+  a   $
a + b < c $
a
a saco
c        /* < b$
c /      * < a$
**out**:
Correct
Error
Correct
Correct
Correct
Error
Error
Error
Error
