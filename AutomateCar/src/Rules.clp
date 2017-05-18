
(printout t "Programming on Jess" crlf)

(bind ?humidade 46)
(bind ?dist 2)
(bind ?velocidade 60)
(bind ?oxigenio 21)

(deftemplate checkTemp
    (slot tempMax)
    (slot tempMin))
(deftemplate car
    (slot temp)
    )

(defrule goodTemp
  	?carro <- (car (temp ?temp))
    ?checkao <- (checkTemp(tempMax ?max)(tempMin ?min))
    (?temp < ?max && ?temp > ?min)
    
    =>
    
    (printout t "Good temp" crlf)
    
    ) 

(assert(carro(temp 23)))
(assert(checkao(tempMax 25) (tempMin 20)))


(watch all)

(run)


(defrule notHot
    (< ?temp 25)
    
    =>
    
    (printout t "It's too Hot, cooling down!" crlf)
    )

(defrule notCold
    (printout t "Good Temp")
    (> ?temp 20)
    
    =>
    
    (printout t "It's too Cold, increasing heat!" crlf)
    )
