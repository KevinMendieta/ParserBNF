# TCOM
A simple parser of expresions with a, b, c and operators +, -, /, *, whith $ as end of line.
## Examples
**in**:<br />
a$<br />
a+$<br />
a < b<br />
a + b = c<br />
a     +      b      + c     +a-   b/a    *   c < c$<br />
a     +      b      + c     +a-   b/a    *   c < c    - a   / b    *  c+  a   $<br />
a + b < c $<br />
a<br />
a saco<br />
c        /* < b$<br />
c /      * < a$<br />
**out**:<br />
Correc<br />
Error<br />
Correct<br />
Correct<br />
Correct<br />
Error<br />
Error<br />
Error<br />
Error<br />
