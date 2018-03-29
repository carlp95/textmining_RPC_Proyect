import os

directory = 'D:/IdeaProjects/textmining_RPC_Proyect/resources/papers/'
conta = 0
for filename in os.listdir(directory):
    if filename.endswith(".txt"):
        file = open(filename, 'r')
        conta += 1
        for line in file:
            print(line)
            if line == 'introduction' or line == 'Introduction':
                filewriter = open('D:/IdeaProjects/textmining_RPC_Proyect/resources/papers/copy{}'.format(str(conta)), 'w')
                filewriter.write(line + '\n' + '------------------------------------------------------------------')
                filewriter.close()
                #print(line + '\n' + "-----------------------------------------------------------------------------------")
    else:
        continue


