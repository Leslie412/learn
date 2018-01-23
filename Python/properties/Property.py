class Property(object):


    def __init__(self, square_feet='', beds='', baths='', **kwargs):
        super().__init__(**kwargs)
        self.squre_feet = square_feet
        self.num_bedrooms = beds
        self.num_baths = baths
        
    def display(self):
        print("square footage: {}".format(self.squre_feet))
        print("bedrooms: {}".format(self.num_bedrooms))
        print("bathrooms: {}".format(self.num_baths))
        
    def prompt_init():
        return dict(square_feet=input("Enter the square: "), 
                    beds=input("Enter number of bedrooms: "), 
                    baths=input("Enter number of baths: "))
    
    prompt_init = staticmethod(prompt_init)