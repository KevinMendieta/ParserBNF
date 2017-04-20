# TCOM
A simple parser of expresions with a, b, c and operators +, -, /, *, whith $ as end of line.
## Examples
**in**: 
a$<br />
a + b = c__
a     +      b      + c     +a-   b/a    *   c < c$__
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
