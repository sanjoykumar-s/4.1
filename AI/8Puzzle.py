def isGoal (grid, goal):
    return grid == goal

def huristic(grid, goal, g):
    count = 0
    for i in range(len(goal)):
        for j in range(len(goal[i])):
            if goal[i][j]!=0 and goal[i][j]!=grid[i][j]:
                count = count + 1
    return count+g

def printMat(grid):
    for i in range(len(grid)):
        print(grid[i])
    print()

def findPoint(tem):
    for i in range(len(tem)):
        for j in range(len(tem[i])):
            if tem[i][j] == 0:
                return (i,j)

def solve(grid, goal, g, blk):
    if g==2:
        return
    (i,j) = findPoint(grid)
    tem = grid
    dir = (0,0)
    f = 10000
    #up
    if i-1 >= 0 and blk!=(-1,0):
        xx = tem[i][j]
        tem[i][j] = tem[i-1][j]
        tem[i-1][j] = xx
        printMat(tem)
        cost = huristic(tem, goal, g)
        if(cost==0):
            return
        elif cost<f:
            f = cost
            dir = (-1,0)

    #down
    tem = grid
    (i,j) = findPoint(tem)
    if i+1 < len(grid) and blk!=(1,0):
        tem = grid
        xx = tem[i][j]
        tem[i][j] = tem[i+1][j]
        tem[i+1][j] = xx
        printMat(tem)
        cost = huristic(tem, goal, g)
        if(cost==0):
            return
        elif cost<f:
            f = cost
            dir = (1,0)

    #left
    tem = grid
    (i,j) = findPoint(tem)
    if j-1 >= 0 and blk!=(0,-1):
        tem = grid
        xx = tem[i][j]
        tem[i][j] = tem[i][j-1]
        tem[i][j-1] = xx
        printMat(tem)
        cost = huristic(tem, goal, g)
        if(cost==0):
            return
        elif cost<f:
            f = cost
            dir = (0, -1)
    
    #Right
    tem = grid
    (i,j) = findPoint(tem)
    if j+1 <len(grid[0]) and blk!=(0,1):
        tem = grid
        xx = tem[i][j]
        tem[i][j+1] = tem[i][j+1]
        tem[i][j+1] = xx
        printMat(tem)
        cost = huristic(tem, goal, g)
        if(cost==0):
            return
        elif cost<f:
            f = cost
            dir = (0, 1)
    
    if dir == (0,0) or f==0:
        return

    tem[i][j], tem[i+dir[0]][j+dir[1]] = tem[i+dir[0]][j+dir[1]], tem[i][j]
    if dir[0] == -1:
        print("Go Up")
    elif dir[0] == 1:
        print("Go Down")
    elif dir[1] == -1:
        print("Go left")
    else:
        print("Go left")
    solve(tem, goal, g+1, dir)

grid = [[2,8,3], [1,6,4], [7,0,5]]
goal = [[1,2,3],[8,0,4],[7,6,5]]
blk = (-1,-1)
print(grid)
print()
solve(grid,goal,0, blk)
