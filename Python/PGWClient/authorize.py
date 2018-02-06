import PGWClient.utilities as utilities
import PGWClient.pgwEntities as entity
import os
import sys





















def main():
    '''get constant from setting file'''
    pgwConfig = utilities.readProfile("config.json")
    






if __name__ == '__main__':
#     print(os.path.dirname(sys.modules[__name__].__file__))
    print(utilities.readProfile("config.json"))