ltrs = ['','C','D','E','G','H','I','K','L','O','S','U','W','Y']
stop = 8333092520403744490

lower = 0
upper = 0
r = 1
c = 1
while True:
    c += 1
    r *= len(ltrs)-1
    upper += r
    lower = upper - r + 1
    if (upper > stop):
        break

f = ''
for l in range(c-1, -1, -1):
    upper = lower + (len(ltrs)-1)**l - 1
    for i in range(1,len(ltrs)):
        if (upper >= stop):
            f += ltrs[i]
            break
        lower = upper + 1
        if (l != 0):
            upper += ((len(ltrs)-1)**l)
        else: 
            upper += 1
    if (len(f) == len):
        break
print(f[1:])