# CodeUInterview
solution to the technical problem asked on the formal interview from CodeU program at Google.<br/>

### Files
1. Interview Solution - the solution as written in the interview itself. Comments were added to explain some of the function and classes used but no written. 
2. Afterthought Solution - the solution that I came up with after the interview was done. The strategy used in this solution is based on the idea from the interview solution. I implemented the functions and classes used in the interview solution, and did my best to stick to the same names and structure so the two solutions are as comparable as possible.

## The Technical Problem
*DVR remote problem*</br>
there is a remote control with these buttons:
up, down, left and right and enter

there is TV screen with the alphabet above and a cursor that has a particular letter selected

If you push enter, you select the letter the cursor is currently on.

Given the name of a movie, like “Up” or “Guardians”, and the cursor at letter a.
Output the sequence of button presses (including enter) to produce that string.

### Example
the remote when the cursor is on the letter "a".
```
a b c d e 
f g h i j 
k l m n o 
p q r s t 
u v w x y 
z 
```

**Note:**
- Do not worry about case sensetivity
- The letters on the remote are given at the following example
- Solution should count on the given formation (where there are 6 rows and 5 cols)


