import json

class Item(object):
    def __init__(self, id, price, quantity, name):
        self.p_id = id
        self.price = price
        self.quantity = quantity
        self.name = name

class Order(object):
    def __init__(self, email, ipAddress, items, version="1"):
        self.version = version
        self.email = email
        self.ipAddress = ipAddress
        self.items = items

class Card():
    def __init__(self, amount, cardNumber, cardHolderName, expirationDate, withThreeDSecure="false", version="1"):
        self.amount = amount
        self.cardNumber = cardNumber
        self.cardHolderName = cardHolderName
        self.expirationDate = expirationDate
        self.withThreeDSecure = withThreeDSecure
        self.version = version

class Payment(object):
    def __init__(self, serviceId, subServiceId, timestamp, paymentId, grossAmount, agencyCode, callbackUrl, card, order, currencyCode="JPY"):
        self.serviceId = serviceId
        self.subServiceId = subServiceId
        self.timestamp = timestamp
        self.paymentId = paymentId
        self.currencyCode = currencyCode
        self.grossAmount = grossAmount
        self.agencyCode = agencyCode
        self.callbackUrl = callbackUrl
        self.card = card
        self.order = order

class PaymentResponse(object):
    def __init__(self, resultType, transactionTime, paymentId, agencyCode, agencyRequestId, errorCode, errorMessage):
        self.resultType = resultType
        self.transactionTime = transactionTime
        self.paymentId = paymentId
        self.agencyCode = agencyCode
        self.agencyRequestId = agencyRequestId
        self.errorCode = errorCode
        self.errorMessage = errorMessage
        
if __name__ == "__main__":
    item = Item("itemId", "100", "2", "Any name")
    itemLst = []
    itemLst.append(item)
    order = Order("test@rakuten.com", "123.123.123.123", itemLst)
    card = Card("200", "4444333322221111", "Rakuten Taro", "202001")
    payment = Payment("stg-serviceid", "stg-sub_serviceid", "2016-12-02 04:40:44.000", "A123456", "200", "worldpay", "https://localhost", card, order)
    print(json.dumps(payment, default=lambda o: o.__dict__))
