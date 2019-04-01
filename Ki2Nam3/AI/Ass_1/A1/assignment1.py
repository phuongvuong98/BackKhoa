import time
start = time.time()

import numpy as np
import random
import copy

def printMat(mat):
    for x in range(len(mat)):
        print(mat[x])
     
def createMat(mat, n, k):
    for x in range(n-1):
        # all() tra ve True hoac False.
        # neu sum so 1 moi hang = k thi tra ve mat
        if (all(mat[x].count(1) == k for x in range(n))):
            return mat
        # neu co truong hop sum so 1 moi hang < k thi
        while (mat[x].count(1) < k):
            a = x+1
            min = mat[x+1].count(1)
            for y in range(x+2, n):
                if (mat[y].count(1) < min):
                    min = mat[y].count(1)
                    a = y
            mat[x][a] = 1
            mat[a][x] = mat[x][a] # tao doi xung
    return mat

def findMilestone(mat, n, k, score):
    sumScoreAve = []
    for x in range(n):
        sumScoreAve.append(0)
    
    for i in range(n):
        for j in range(n):
            if (mat[i][j] == 1):
                sumScoreAve[i] = sumScoreAve[i] + score[j]
        sumScoreAve[i] = sumScoreAve[i] / k
    milestone = np.std(sumScoreAve, dtype=np.float64)
    return mat, milestone

def findMainMat(TempMat, n, k, score, milestone, updateMiles, sum, sumScoreAve, saveMat):
    for x in range(n):
        sumScoreAve.append(0)
    for x in range(n):
        for y in range(n):
            if (x == y): 
                continue
            begin = y + 1
            for runRow in range(begin ,n - 1):
                if (TempMat[x][y] + TempMat[x][runRow] == 1 and x != runRow):
                    beginDown = x + 1
                    for a in range(beginDown, n):
                        if (TempMat[x][y] + TempMat[a][y] == 1 and TempMat[x][runRow] + TempMat[a][runRow] == 1 and a != y and a != runRow):
                            sum = sum + 1

                            mat = copy.deepcopy(createMat(TempMat, n, k))
                            # hoan doi cac vi tri
                            mat[x][y], mat[x][runRow] = mat[x][runRow], mat[x][y]
                            mat[a][y], mat[a][runRow] = mat[a][runRow], mat[a][y]

                            # cap nhat ma tran doi xung
                            mat[y][x] = mat[x][y]
                            mat[y][a] = mat[a][y]
                            mat[runRow][x] = mat[x][runRow]
                            mat[runRow][a] = mat[a][runRow]

                            for i in range(n):
                                for j in range(n):
                                    if (mat[i][j] == 1):
                                        sumScoreAve[i] = sumScoreAve[i] + score[j]
                                sumScoreAve[i] = sumScoreAve[i] / k

                            standardDeviation = np.std(sumScoreAve, dtype=np.float64)

                            if (updateMiles > standardDeviation):
                                updateMiles = standardDeviation
                                saveMat = copy.deepcopy(createMat(mat, n, k))

    if (updateMiles > milestone):
        return saveMat, milestone
    elif (updateMiles == milestone):
        saveMat = copy.deepcopy(createMat(TempMat, n, k))
        return saveMat, updateMiles
    else:
        saveMat = copy.deepcopy(createMat(TempMat, n, k))
        milestone = updateMiles
        return findMainMat(saveMat, n, k, score, milestone, 0, 0, [], [[]])

def main(file_input, file_output):
    # Doc tu file
    fi = open("input.txt","r+")
    score = []
    # n, k , score lan luot la sum so van dong vien, so tran dau, so diem tung van dong vien
    with open('input.txt') as fi:
        n, k = [int(x) for x in next(fi).split()]
        for line in fi:
            if line == "\n":
                continue
            score = score + [int(line)]
    fi.close()
##########################################################
    # Chay giai thuat
    
    matrix =[]
    sum = n*k/2 # sum so tran dau cua tat ca van dong vien

    # Tao ma tran ke can N x N 
    for x in range(n):
        matrix = matrix + [[]]
        for y in range(n):          
            matrix[x].append(0)
    
    # sao chep tu ma tran ban dau
    TempMatrix = copy.deepcopy(createMat(matrix, n, k))
    matInit, milestone = findMilestone(TempMatrix, n, k, score)
    
    updateMiles = milestone
    sum = 0
    sumScoreAve = []
    saveMat = [[]]
    saveMat, milestone = findMainMat(TempMatrix, n, k, score, milestone, updateMiles, sum, sumScoreAve, saveMat)

    printMat(saveMat)
    print("Milestone", milestone)

    fo = open("output.txt","w+")
    for x in range(n):
        for y in range(n):
            if (saveMat[x][y] == 1):
                fo.write("%d\r\n" % (y+1))
    fo.close()
 
    # Viet ra file
main('input.txt', 'output.txt')


end = time.time()
print("Thoi gian chay: ", end - start, "s")