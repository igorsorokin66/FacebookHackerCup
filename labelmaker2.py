import math

ltrs = 'ADEFHNOPSUVY'
stop = 3365973428406169086
expectedLength = int(math.ceil(math.log(stop)/math.log(len(ltrs))))#thank you leena
print expectedLength
a = expectedLength - 1

factorial = 0
for i in range(1, expectedLength):
	factorial += len(ltrs)**i

f = ''
prev = 0
val = 0
subtract = 0
for i in range(0,expectedLength):
	subtract = factorial + val + (len(ltrs)**(a+1) * prev) + 1
	val += (len(ltrs)**(a+1) * prev)
	prev = (stop - subtract) / len(ltrs)**a
	f += ltrs[prev]
	a -= 1
print f