import copy

arr = [[0 for i in range(5)] for j in range(5)]
backup = [[0 for i in range(5)] for j in range(5)]
# arr = [[0] * 5] * 5
# backup = [[0] * 5] * 5
n = int(input())
dires = [[0, 0], [-1, 0], [1, 0], [0, -1], [0, 1]]


def turn(x, y):
    for dire in dires:
        a, b = x + dire[0], y + dire[1]
        if a < 0 or a >= 5 or b < 0 or b >= 5:
            continue
        arr[a][b] ^= 1


for k in range(n):
    for i in range(5):
        a = input()
        for j in range(5):
            arr[i][j] = int(a[j])
    if k < n - 1:
        c = input()
    ans = 10
    backup = copy.deepcopy(arr)
    for l in range(32):
        step = 0
        for i in range(5):
            op = l >> i & 1
            if op == 1:
                turn(0, i)
                step += 1
        for i in range(1, 5):
            for j in range(5):
                if arr[i - 1][j] == 0:
                    turn(i, j)
                    step += 1
        dark = False
        for i in range(5):
            if arr[4][i] == 0:
                dark = True
                break
        if not dark:
            ans = min(ans, step)
        arr = copy.deepcopy(backup)
    if ans > 6:
        print(-1)
    else:
        print(ans)
