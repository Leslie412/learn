'''
Created on 2017/12/20

@author: wenwu.zhang
'''
import sys
import unicodedata
import struct
from myPythonLearn.Point import Point

def print_unicode_table(word):
    code = ord(" ")
    end = sys.maxunicode
    
    while code < end:
        c = chr(code)
        name = unicodedata.name(c, "*** unknown ***")
        if word is None or word in name.lower():
            print("{0:7} {0:5X} {0:^3c} {1}".format(code, name.title()))
            code += 1

def extract_from_tag_1(tag, line):
    opener = "<" + tag + ">"
    closer = "</" + tag + ">"
    try:
        i = line.index(opener)
        start = i + len(opener)
        j = line.index(closer, start)
        return line[start:j]
    except ValueError:
        return None

def extract_from_tag_2(tag, line):
    opener = "<" + tag + ">"
    closer = "</" + tag + ">"
    i = line.find(opener)
    if i != -1:
        start = i + len(opener)
        j = line.find(closer, start)
        if j != -1:
            return line[start:j]
    return None
    
'''            
word = None
if len(sys.argv) > 1:
    if sys.argv[1] in ("-h", "--help"):
        print("usage: {0} string".format(sys.argv[0]))
        word = 0
    else:
        word = sys.argv[1].lower()
if word != 0:
    print_unicode_table(word)

print(extract_from_tag_1("html", "<html>title</html>"))
print(extract_from_tag_2("html", "<html>title</html>"))

unit16 = struct.Struct("<H")
print(unit16.size)
''' 

def test_struct(data):
    data_format = "<H{0}s".format(len(data))
    print((struct.Struct("<H10s")).size)
    test_data = data.encode("utf8")
    return struct.pack(data_format, len(test_data), test_data)


def main():    
    point1 = Point(1, 1)
    point2 = Point(2, 2)

    point1.reset()
    point2.move(5, 1)
    print(point2.calculate_distance(point1))
    point1.showName()
    print(__name__)
    
main()