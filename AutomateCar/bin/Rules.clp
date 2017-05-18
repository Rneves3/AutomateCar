import main.java

(defrule highTemp
    (> ?temp ?tempMax)
    =>
    (decreaseTemp(?Temp)))
    