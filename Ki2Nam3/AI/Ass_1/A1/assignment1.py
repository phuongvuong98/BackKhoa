def main(file_input, file_output):
    # read input
    file = open(file_input, 'r')
    atheletesCount, matchCount = [int(x) for x in next(file).split()]
    arrScoreAthe = []
    for line in file:
        arrScoreAthe.append(int(line))
    file.close()
    # run algorithm

    # write output

    return
main('input.txt', 'output.txt')