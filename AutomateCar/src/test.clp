(printout t "CE QUE VER ESSA PORRA" crlf)

(import nrc.fuzzy.jess.*)
(import nrc.fuzzy.*)

(watch all)

(rules)

;;  variables

(deftemplate temperature     (slot celsius))
(deftemplate time            (slot hours))
(deftemplate velocity        (slot ms))
(deftemplate fuel            (slot litres))
(deftemplate oxigen          (slot cubicmeters))
(deftemplate passengerweight (slot kilograms))


;;  facts

(reset)

(assert (cartemperature     2))
(assert (carvelocity        100))
(assert (carfuel            0.5))
(assert (carpassengerweight 666))

(facts)

;;(assert( (tempMax 25) (tempMin 20)))

;; (bind ?humidade 46)
;; (bind ?dist 2)
;; (bind ?velocidade 60)
;; (bind ?oxigenio 21)




;;  rules

(defrule tooHot
    (temperature {celsius >= 26})
    (time        {hours > 12 && hours < 19})
=>
    (printout t "its too hot" crlf)
    (printout t "open the windows and air conditioning" t crlf))

    
(defrule tooCold
    (temperature {celsius <= 0})
=>
    (printout t "its too cold here" crlf)
    (printout t "on the air conditioning and close windows" crlf))

    
(defrule lowFuel
    (fuel {litres <= 1})
=>
    (printout t "you are low on fuel, go to a gas station or something, get your J U I C E on" crlf)
    (printou t "activate gps" crlf))
    

(defrule tooHeavy
    (passengerweight {kilograms >= 400})
=>
    (printout t "too much weight on the car, someone or something needs to gtfo" crlf)
    (printout t "activate brakes" crlf))
    
(run)
    
(watch all)