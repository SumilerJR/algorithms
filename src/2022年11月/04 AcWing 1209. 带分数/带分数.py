# https://www.acwing.com/problem/content/1211/

n = int(input())
length = len(str(n))
state = [0] * 10
cnt = 0


def dfs_c(a, c):
    b = c * (n - a)
    if len(str(a)) + len(str(b)) + len(str(c)) > 9:
        return
    if set(str(a) + str(b) + str(c)) == set("123456789"):
        global cnt
        cnt += 1
    for i in range(1, 10):
        if state[i] == 0:
            state[i] = 1
            dfs_c(a, c * 10 + i)
            state[i] = 0


def dfs_a(a):
    if a >= n:
        return
    if a != 0:
        dfs_c(a, 0)
    for i in range(1, 10):
        if state[i] == 0:
            state[i] = 1
            dfs_a(a * 10 + i)
            state[i] = 0


dfs_a(0)
print(cnt)




