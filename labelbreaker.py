word = 'FACEBOOK'
list = sorted(set(word))

l = len(word)-1
temp = 0
total = 0
for i in range(0,len(word)):
	for n in range(0,len(list)):
		temp += len(list)**l
		if word[i] == list[n]:
			total += temp
			break
	temp = 0
	l -= 1
print total