from properties.Property import Property

class Apartment(Property):
    valid_laundries = ("coin", "ensuite", "none")
    valid_balconies = ("yes", "no", "solarium")

    def __init__(self, balcony='', laundry='', **kwargs):
        super().__init__(**kwargs)
        self.balcony = balcony
        self.laundry = laundry
        
    def display(self):
        super().display()
        print("laundry: {0}".format(self.laundry))
    
def main():
    args = Property.prompt_init()
    apart = Apartment(2, 2, **args)
    apart.display()

main()