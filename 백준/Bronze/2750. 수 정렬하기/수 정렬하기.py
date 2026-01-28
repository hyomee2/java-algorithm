num=int(input())
a=[]
for _ in range(num):
    a.append(int(input()))
for j in range(num):
    for i in range(num-j-1):
        if a[i]>a[i+1]:
            temp=a[i+1]
            a[i+1]=a[i]
            a[i]=temp
for i in range(num):
    print(a[i])