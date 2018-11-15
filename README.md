# java8-streaming
Playing with functional java8 style streaming api. <br />

# How to use <br />

import to eclipse the maven project and run tests inside eclipse to see outputs. <br />

actual output <br />
<br />
25000.0 <br />
28000.0 <br />
28000.0 <br />
30000.0 <br />
<br />

total sum is 201000.0 <br />
max product price is 90000.0 <br />
min product price is 25000.0 <br />
productPriceSet is [25000.0, 28000.0] <br />
productPriceMap is {1=HP Laptop, 2=Dell Laptop, 3=Lenevo Laptop, 4=Sony Laptop, 5=Apple Laptop} <br />
productPriceList is [90000.0] <br />
Now parallelizing... <br />
25000.0 <br />
28000.0 <br />
28000.0 <br />
30000.0 <br />
total sum is 201000.0 <br />
 <br />
max product price is 90000.0 <br />
min product price is 25000.0 <br />
productPriceSet is [25000.0, 28000.0] <br />
productPriceMap is {1=HP Laptop, 2=Dell Laptop, 3=Lenevo Laptop, 4=Sony Laptop, 5=Apple Laptop} <br />
productPriceList is [90000.0] <br />
Creating stream from collection, set or array... <br />
JAVA <br />
J2EE <br />
Spring <br />
Hibernate <br />
JAVA <br />
J2EE <br />
Spring <br />
Hibernate <br />
JAVA <br />
Hibernate <br />
J2EE <br />
Spring <br />
 <br />
Array can also be a source of a Stream... <br />
a <br />
b <br />
c <br />
a <br />
b <br />
c <br />
b <br />
c <br />
from streamBuilder... <br />
a <br />
b <br />
c <br />
From Stream.generate()... <br />
element <br />
element <br />
element <br />
element <br />
element <br />
element <br />
element <br />
element <br />
element <br />
element <br />
From Stream.iterate()... <br />
1 <br />
3 <br />
5 <br />
7 <br />
9 <br />
Stream of File... <br />
// Attention, file not provided, use your own file!  <br />
2018/05/06 20:54:42,200 WARN  BaseVisitor                      There were configuration errors! <br />
LoosePackageCoupling: No packages or classes specified <br />
 <br />
2018/05/06 20:54:42,200 WARN  BaseVisitor                      There were configuration errors! <br />
LoosePackageCoupling: No packages or classes specified <br />
 <br />
Stream of Primitives... <br />
1 <br />
2 <br />
1 <br />
2 <br />
3 <br />
0.050415604442980655  <br />
0.47084556420331924 <br />
0.24412032084607604 <br />
 <br />
sorting a hashMap by value <br />
{b=10, c=12, d=20, a=21}  <br />
 <br />

reading historico_euromillones.csv sorted by total_2017, 7 values... <br />
EMPojo [number=17, total=131, total_2017=16, total_2018=15] <br />
EMPojo [number=30, total=127, total_2017=16, total_2018=7] <br />
EMPojo [number=20, total=119, total_2017=14, total_2018=12] <br />
EMPojo [number=4, total=132, total_2017=13, total_2018=10] <br />
EMPojo [number=10, total=125, total_2017=13, total_2018=6] <br />
EMPojo [number=19, total=126, total_2017=13, total_2018=3] <br />
EMPojo [number=27, total=121, total_2017=13, total_2018=8] <br />
<br />
reading historico_euromillones.csv sorted by total_2018, 7 values... <br />
EMPojo [number=15, total=126, total_2017=9, total_2018=17] <br />
EMPojo [number=17, total=131, total_2017=16, total_2018=15] <br />
EMPojo [number=23, total=135, total_2017=10, total_2018=15] <br />
EMPojo [number=44, total=138, total_2017=13, total_2018=14] <br />
EMPojo [number=48, total=109, total_2017=11, total_2018=14] <br />
EMPojo [number=31, total=115, total_2017=13, total_2018=13] <br />
EMPojo [number=50, total=140, total_2017=11, total_2018=13] <br />
<br />

reading Lotoideas.com - Histórico de Resultados - Euromillones - 2004 a 2018-2.csv... <br />
There are 1137 lines in the file. Lets try to find something useful. <br />
Data comes from 2004 to 2018.<br />
<br />
Winer1 list and number of times <br />
winer1 1 appeared 114 times.<br />
winer1 2 appeared 91 times.<br />
winer1 3 appeared 96 times.<br />
winer1 4 appeared 93 times.<br />
winer1 5 appeared 84 times.<br />
winer1 6 appeared 83 times.<br />
winer1 7 appeared 67 times.<br />
winer1 8 appeared 53 times.<br />
winer1 9 appeared 50 times.<br />
winer1 10 appeared 49 times.<br />
winer1 11 appeared 45 times.<br />
winer1 12 appeared 49 times.<br />
winer1 13 appeared 38 times.<br />
winer1 14 appeared 41 times.<br />
winer1 15 appeared 24 times.<br />
winer1 16 appeared 21 times.<br />
winer1 17 appeared 24 times.<br />
winer1 18 appeared 15 times.<br />
winer1 19 appeared 15 times.<br />
winer1 20 appeared 17 times.<br />
winer1 21 appeared 10 times.<br />
winer1 22 appeared 9 times.<br />
winer1 23 appeared 13 times.<br />
winer1 24 appeared 6 times.<br />
winer1 25 appeared 4 times.<br />
winer1 26 appeared 5 times.<br />
winer1 27 appeared 4 times.<br />
winer1 28 appeared 2 times.<br />
winer1 29 appeared 4 times.<br />
winer1 31 appeared 4 times.<br />
winer1 32 appeared 2 times.<br />
winer1 33 appeared 1 times.<br />
winer1 34 appeared 1 times.<br />
winer1 35 appeared 2 times.<br />
winer1 38 appeared 1 times.<br />
<br />
Winer2 list and number of times<br />
winer2 2 appeared 5 times.<br />
winer2 3 appeared 15 times.<br />
winer2 4 appeared 34 times.<br />
winer2 5 appeared 33 times.<br />
winer2 6 appeared 26 times.<br />
winer2 7 appeared 44 times.<br />
winer2 8 appeared 44 times.<br />
winer2 9 appeared 40 times.<br />
winer2 10 appeared 50 times.<br />
winer2 11 appeared 58 times.<br />
winer2 12 appeared 43 times.<br />
winer2 13 appeared 44 times.<br />
winer2 14 appeared 43 times.<br />
winer2 15 appeared 58 times.<br />
winer2 16 appeared 49 times.<br />
winer2 17 appeared 54 times.<br />
winer2 18 appeared 38 times.<br />
winer2 19 appeared 49 times.<br />
winer2 20 appeared 47 times.<br />
winer2 21 appeared 39 times.<br />
winer2 22 appeared 29 times.<br />
winer2 23 appeared 38 times.<br />
winer2 24 appeared 37 times.<br />
winer2 25 appeared 32 times.<br />
winer2 26 appeared 32 times.<br />
winer2 27 appeared 24 times.<br />
winer2 28 appeared 18 times.<br />
winer2 29 appeared 28 times.<br />
winer2 30 appeared 21 times.<br />
winer2 31 appeared 8 times.<br />
winer2 32 appeared 12 times.<br />
winer2 33 appeared 9 times.<br />
winer2 34 appeared 7 times.<br />
winer2 35 appeared 5 times.<br />
winer2 36 appeared 11 times.<br />
winer2 37 appeared 5 times.<br />
winer2 38 appeared 1 times.<br />
winer2 39 appeared 2 times.<br />
winer2 40 appeared 2 times.<br />
winer2 41 appeared 1 times.<br />
winer2 42 appeared 1 times.<br />
winer2 44 appeared 1 times.<br />
<br />
Winer3 list and number of times<br />
winer3 6 appeared 4 times.<br />
winer3 7 appeared 5 times.<br />
winer3 8 appeared 8 times.<br />
winer3 9 appeared 13 times.<br />
winer3 10 appeared 22 times.<br />
winer3 11 appeared 13 times.<br />
winer3 12 appeared 19 times.<br />
winer3 13 appeared 25 times.<br />
winer3 14 appeared 28 times.<br />
winer3 15 appeared 35 times.<br />
winer3 16 appeared 28 times.<br />
winer3 17 appeared 37 times.<br />
winer3 18 appeared 36 times.<br />
winer3 19 appeared 41 times.<br />
winer3 20 appeared 44 times.<br />
winer3 21 appeared 48 times.<br />
winer3 22 appeared 43 times.<br />
winer3 23 appeared 48 times.<br />
winer3 24 appeared 46 times.<br />
winer3 25 appeared 49 times.<br />
winer3 26 appeared 53 times.<br />
winer3 27 appeared 43 times.<br />
winer3 28 appeared 42 times.<br />
winer3 29 appeared 41 times.<br />
winer3 30 appeared 47 times.<br />
winer3 31 appeared 41 times.<br />
winer3 32 appeared 30 times.<br />
winer3 33 appeared 27 times.<br />
winer3 34 appeared 33 times.<br />
winer3 35 appeared 32 times.<br />
winer3 36 appeared 30 times.<br />
winer3 37 appeared 29 times.<br />
winer3 38 appeared 22 times.<br />
winer3 39 appeared 23 times.<br />
winer3 40 appeared 13 times.<br />
winer3 41 appeared 10 times.<br />
winer3 42 appeared 11 times.<br />
winer3 43 appeared 8 times.<br />
winer3 44 appeared 3 times.<br />
winer3 45 appeared 2 times.<br />
winer3 46 appeared 1 times.<br />
winer3 47 appeared 4 times.<br />
<br />
Winer4 list and number of times<br />
winer4 10 appeared 3 times.<br />
winer4 11 appeared 3 times.<br />
winer4 12 appeared 2 times.<br />
winer4 13 appeared 4 times.<br />
winer4 14 appeared 8 times.<br />
winer4 15 appeared 5 times.<br />
winer4 16 appeared 6 times.<br />
winer4 17 appeared 12 times.<br />
winer4 18 appeared 8 times.<br />
winer4 19 appeared 20 times.<br />
winer4 20 appeared 10 times.<br />
winer4 21 appeared 19 times.<br />
winer4 22 appeared 19 times.<br />
winer4 23 appeared 27 times.<br />
winer4 24 appeared 19 times.<br />
winer4 25 appeared 33 times.<br />
winer4 26 appeared 24 times.<br />
winer4 27 appeared 41 times.<br />
winer4 28 appeared 41 times.<br />
winer4 29 appeared 38 times.<br />
winer4 30 appeared 41 times.<br />
winer4 31 appeared 41 times.<br />
winer4 32 appeared 38 times.<br />
winer4 33 appeared 36 times.<br />
winer4 34 appeared 41 times.<br />
winer4 35 appeared 53 times.<br />
winer4 36 appeared 44 times.<br />
winer4 37 appeared 53 times.<br />
winer4 38 appeared 67 times.<br />
winer4 39 appeared 48 times.<br />
winer4 40 appeared 53 times.<br />
winer4 41 appeared 34 times.<br />
winer4 42 appeared 42 times.<br />
winer4 43 appeared 46 times.<br />
winer4 44 appeared 40 times.<br />
winer4 45 appeared 42 times.<br />
winer4 46 appeared 23 times.<br />
winer4 47 appeared 21 times.<br />
winer4 48 appeared 18 times.<br />
winer4 49 appeared 14 times.<br />
<br />
Winer5 list and number of times<br />
winer5 1 appeared 114 times.<br />
winer5 2 appeared 91 times.<br />
winer5 3 appeared 96 times.<br />
winer5 4 appeared 93 times.<br />
winer5 5 appeared 84 times.<br />
winer5 6 appeared 83 times.<br />
winer5 7 appeared 67 times.<br />
winer5 8 appeared 53 times.<br />
winer5 9 appeared 50 times.<br />
winer5 10 appeared 49 times.<br />
winer5 11 appeared 45 times.<br />
winer5 12 appeared 49 times.<br />
winer5 13 appeared 38 times.<br />
winer5 14 appeared 41 times.<br />
winer5 15 appeared 24 times.<br />
winer5 16 appeared 21 times.<br />
winer5 17 appeared 24 times.<br />
winer5 18 appeared 15 times.<br />
winer5 19 appeared 15 times.<br />
winer5 20 appeared 17 times.<br />
winer5 21 appeared 10 times.<br />
winer5 22 appeared 9 times.<br />
winer5 23 appeared 13 times.<br />
winer5 24 appeared 6 times.<br />
winer5 25 appeared 4 times.<br />
winer5 26 appeared 5 times.<br />
winer5 27 appeared 4 times.<br />
winer5 28 appeared 2 times.<br />
winer5 29 appeared 4 times.<br />
winer5 31 appeared 4 times.<br />
winer5 32 appeared 2 times.<br />
winer5 33 appeared 1 times.<br />
winer5 34 appeared 1 times.<br />
winer5 35 appeared 2 times.<br />
winer5 38 appeared 1 times.<br />
<br />
Star1 list and number of times<br />
star1 1 appeared 203 times.<br />
star1 2 appeared 201 times.<br />
star1 3 appeared 177 times.<br />
star1 4 appeared 132 times.<br />
star1 5 appeared 123 times.<br />
star1 6 appeared 89 times.<br />
star1 7 appeared 72 times.<br />
star1 8 appeared 74 times.<br />
star1 9 appeared 51 times.<br />
star1 10 appeared 12 times.<br />
star1 11 appeared 3 times.<br />
<br />
Star2 list and number of times<br />
star2 1 appeared 7 times.<br />
star2 2 appeared 29 times.<br />
star2 3 appeared 54 times.<br />
star2 4 appeared 62 times.<br />
star2 5 appeared 101 times.<br />
star2 6 appeared 108 times.<br />
star2 7 appeared 138 times.<br />
star2 8 appeared 162 times.<br />
star2 9 appeared 178 times.<br />
star2 10 appeared 136 times.<br />
star2 11 appeared 131 times.<br />
star2 12 appeared 31 times.<br />
<br />

<br />