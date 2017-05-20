(import nrc.fuzzy.jess.*)
(import nrc.fuzzy.*)

;;  variables

(deftemplate temperature     (slot celsius))
(deftemplate time            (slot hours))
(deftemplate velocity        (slot kmh))
(deftemplate fuel            (slot litres))
(deftemplate oxigen          (slot cubic))
(deftemplate distance		 (slot maxDist))


;;  facts

(assert (temperature (celsius 27)))
(assert (velocity (kmh 160)))
(assert (fuel (litres 3)))
(assert(Sunny))

(facts)

;;(assert( (tempMax 25) (tempMin 20)))

;; (bind ?humidade 46)
;; (bind ?dist 2)
;; (bind ?velocidade 60)
;; (bind ?oxigenio 21)

;; maybe check lights on or off aswell as windows and turning them on or off, opening or closing respectively



;;  rules

(defrule tooHot
    (temperature {celsius >= 26})
=>
    (printout t "Too Hot, turning on the AC!" crlf))
    
(defrule tooCold
    (temperature {celsius <= 0})
=>
    (printout t "Too Cold, turning on the Heater!" crlf))
   
(defrule lowFuel
    (fuel {litres <= 5})
=>
    (printout t "Low on fuel, head to the nearest gas station. Turning on GPS" crlf))
    
(defrule clearDay
	(time {hours > 9 && hours < 19})
    (Sunny)
    =>
   (printout t "The day is Sunny and clear, no lights needed" crlf))
    
(defrule cloudyDay
	(time {hours > 9 && hours < 19})
    (Cloudy)
    =>
   (printout t "The day is Cloudy, turning on medium lights" crlf))

(defrule darkDay
	(time {hours > 19 && hours < 7})
    (Dark)
    =>
   (printout t "The day is Dark, turning on lights" crlf))

(defrule SunSet
	(time {hours > 19 && hours < 21})
    (Sunny)
    =>
   (printout t "The sun is setting, turning on medium lights" crlf))

(defrule SunRise
	(time {hours > 7 && hours < 9})
    (Sunny)
    =>
   (printout t "The sun is rising, turning on medium lights" crlf))

(defrule tooFast
	(velocity {kmh > 150})
    =>
   (printout t "Going to fast, slowing you down or you'll get a ticket!" crlf))

(defrule lowOxigen
	(oxigen {cubic < 21})
    =>
   (printout t "Low oxigen levels, opening windows!" crlf))

(defrule tooFar
	(distance {maxDist > 2})
    =>
   (printout t "Owner of the key is too far away, locking car!" crlf))

(run)