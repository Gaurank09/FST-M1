class Car:

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " has started moving")

    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped moving")

car1 = Car("Toyota", "Corolla", "2016", "Automatic", "White")
car2 = Car("Suzuki", "SX4", "2009", "Manual", "Blue")
car3 = Car("Suzuki", "Swift", "2017", "Automatic", "Silver")
car4 = Car("Ford", "Ecosport", "2014", "Manual", "Black")
car5 = Car("Honda", "City", "2016", "Manual", "Red")

car5.accelerate()
car5.stop()