import json
import base64
import datetime
import hmac
import hashlib



def readProfile(filePath):
    with open(filePath) as profile:
        profile_obj = json.load(profile)
        return profile_obj

def encodeBase64(oriStr):
    return base64.b64encode(bytes(oriStr, "utf-8"))

def getUTCtime():
    return datetime.datetime.utcnow()

def getSigniture(text, key):
    secret = bytes(key.ljust(64), "utf-8")
    message = bytes(text, "utf-8")
    return hmac.new(secret, message, digestmod=hashlib.sha256).digest()
    
def encodePaymentResquest(payment):
    return json.dumps(payment, default=lambda o: o.__dict__)


    

if __name__ == "__main__":
    profile = readProfile(r"C:\work\Projects\574_TokenNization\jp-mobile\test\profile.json")
    print(profile)
    print(encodeBase64("abcdefg hijklmn/ert"))
    print(datetime.datetime.utcnow())
    print(getSigniture("test", "key"))