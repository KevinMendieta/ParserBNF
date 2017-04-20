# TCOM
A simple parser of expresions with a, b, c and operators +, -, /, *, whith $ as end of line.
## Examples
**in**: 
a$ 
a + b = c_
a     +      b      + c     +a-   b/a    *   c < c$_
a     +      b      + c     +a-   b/a    *   c < c    - a   / b    *  c+  a   $_
a + b < c $_
a_
a saco_
c        /* < b$_
c /      * < a$_
**out**:
Correct_
Error_
Correct_
Correct_
Correct_
Error_
Error_
Error_
Error_
