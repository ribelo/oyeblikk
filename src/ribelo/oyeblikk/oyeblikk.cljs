(ns ribelo.oyeblikk.oyeblikk
  (:refer-clojure :exclude [compare clone format min max range])
  (:require ["date-fns" :as dt]))

(defn valid? [^js/Date d1]
  (dt/isValid d1))

(defn clone [^js/Date d]
  (js/Date. (.getTime d)))

(defn compare [^js/Date t1 ^js/Date t2]
  (dt/compareAsc t1 t2))

(comment (compare (js/Date.) (js/Date.)))

(defn format [^js/Date d ^string fmt]
  (dt/format d fmt))

(comment (format (js/Date.) "yy.MM.dd"))

(defn format-distance [^js/Date d1 ^js/Date d2 & {:as opts}]
  (dt/formatDistance d1 d2 (clj->js opts)))

(comment (format-distance (js/Date. 2019 1 1 12) (js/Date. 2019 1 1 13)
                          :addSuffix true))

(defn format-distance-strict [^js/Date d1 ^js/Date d2 & {:as opts}]
  (dt/formatDistanceStrict d1 d2 (clj->js opts)))

(comment (format-distance-strict (js/Date. 2019 1 1 12) (js/Date. 2019 1 1 13)
                                 :addSuffix true))

(defn format-relative [^js/Date d1 ^js/Date d2 & {:as opts}]
  (dt/formatRelative d1 d2 (clj->js opts)))

(comment (format-relative (js/Date. 2019 1 1 12) (js/Date. 2019 1 1 13)))

(defn after? [^js/Date d1 ^js/Date d2]
  (> d1 d2))

(defn before? [^js/Date d1 ^js/Date d2]
  (< d1 d2))

(defn date? [^js/Date d1]
  (dt/isDate d1))

(defn equal? [^js/Date d1 ^js/Date d2]
  (= d1 d2))

(defn light-format [^js/Date d ^string fmt]
  (dt/lightFormat d fmt))

(comment (light-format (js/Date.) "yy.MM.dd"))

(defn max [coll]
  (apply max coll))

(defn min [coll]
  (apply min coll))

(defn parse
  ^js/Date
  ([^string s ^string fmt ^string d]
   {:post [(valid? %)]}
   (dt/parse s fmt d))
  ^js/Date
  ([^string s ^string fmt]
   {:post [(valid? %)]}
   (parse s fmt (js/Date.))))

(comment (parse "19.12.31" "yy.MM.dd")
         (parse "19.12.31" "yy.MM.dd" (js/Date.)))

(defn parse-iso [^string s]
  {:post [(valid? %)]}
  (dt/parseISO s))

(comment (parse-iso "2019-12-31"))

(defn to-date [x]
  (dt/toDate x))

(comment (to-date (.getTime (parse-iso "2019-12-31"))))

(defn get-time [^js/Date s]
  (dt/getTime s))

(comment (get-time (parse-iso "2019-12-31")))

(defn get-unix-time [^js/Date s]
  (dt/getUnixTime s))

(defn from-unix-time [^long s]
  (dt/fromUnixTime s))

(defn add-milliseconds [^js/Date d ^long n]
  (dt/addMilliseconds d n))

(defn diffrence-in-milliseconds [^js/Date d1 ^js/Date d2]
  (dt/diffrenceInMilliseconds d1 d2))

(defn milliseconds [^js/Date d]
  (dt/getMilliseconds d))

(defn set-milliseconds [^js/Date d ^long n]
  (dt/setMilliseconds d n))

(defn sub-milliseconds [^js/Date d ^long n]
  (dt/subMilliseconds d n))

(defn add-seconds [^js/Date d ^long n]
  (dt/addSeconds d n))

(defn diffrence-in-seconds [^js/Date d1 ^js/Date d2]
  (dt/diffrenceInSeconds d1 d2))

(defn end-of-second [^js/Date d]
  (dt/endOfSecond d))

(defn seconds [^js/Date d]
  (dt/getSeconds d))

(defn same-second? [^js/Date d1 ^js/Date d2]
  (dt/isSameSecond d1 d2))

(defn set-seconds [^js/Date d ^long n]
  (dt/setSeconds d n))

(defn start-of-second [^js/Date d]
  (dt/startOfSecond d))

(defn sub-seconds [^js/Date d ^long n]
  (dt/subSeconds d n))

(defn add-minutes [^js/Date d ^long n]
  (dt/addMinutes d n))

(defn diffrence-in-minutes [^js/Date d1 ^js/Date d2]
  (dt/diffrenceInMinutes d1 d2))

(defn end-of-minute [^js/Date d]
  (dt/endOfMinute d))

(defn minutes [^js/Date d]
  (dt/getMinutes d))

(defn round-to-nearest-minutes [^js/Date d]
  (dt/roundToNearestMinutes d))

(defn same-minute? [^js/Date d1 ^js/Date d2]
  (dt/isSameMinute d1 d2))

(defn set-minutes [^js/Date d ^long n]
  (dt/setMinutes d n))

(defn start-of-minute [^js/Date d]
  (dt/startOfMinute d))

(defn sub-minutes [^js/Date d ^long n]
  (dt/subMinutes d n))

(defn add-hours [^js/Date d ^long n]
  (dt/addHours d n))

(defn diffrence-in-hours [^js/Date d1 ^js/Date d2]
  (dt/diffrenceInHours d1 d2))

(defn end-of-hour [^js/Date d]
  (dt/endOfHour d))

(defn hours [^js/Date d]
  (dt/getHours d))

(defn same-hour? [^js/Date d1 ^js/Date d2]
  (dt/isSameHour d1 d2))

(defn set-hours [^js/Date d ^long n]
  (dt/setHours d n))

(defn start-of-hour [^js/Date d]
  (dt/startOfHour d))

(defn sub-hours [^js/Date d ^long n]
  (dt/subHours d n))

(defn add-days [^js/Date d ^long n]
  (dt/addDays d n))

(defn diffrence-in-days [^js/Date d1 ^js/Date d2]
  (dt/diffrenceInDays d1 d2))

(defn end-of-day [^js/Date d]
  (dt/endOfDay d))

(defn get-date [^js/Date d]
  (dt/getDate d))

(defn day-of-month [^js/Date d]
  (dt/getDate d))

(defn day-of-year [^js/Date d]
  (dt/getDayOfYear d))

(defn day-of-week [^js/Date d]
  (dt/getISODay d))

(defn same-day? [^js/Date d1 ^js/Date d2]
  (dt/isSameDay d1 d2))

(defn set-day-of-month [^js/Date d ^long day]
  (dt/setDate d day))

(defn set-day-of-year [^js/Date d ^long day]
  (dt/setDays d day))

(defn set-weekday [^js/Date d ^long weekday]
  (dt/setISODay d weekday))

(defn start-of-day [^js/Date d]
  (dt/startOfDay d))

(defn sub-days [^js/Date d ^long n]
  (dt/subDays d n))

(defn monday? [^js/Date d]
  (dt/isMonday d))

(defn tuesday? [^js/Date d]
  (dt/isTuesday d))

(defn wednesday? [^js/Date d]
  (dt/isWednesday d))

(defn thursday? [^js/Date d]
  (dt/isThursday d))

(defn friday? [^js/Date d]
  (dt/isFriday d))

(defn sunday? [^js/Date d]
  (dt/isSunday d))

(defn saturday? [^js/Date d]
  (dt/isSaturday d))

(defn add-weeks [^js/Date d ^long n]
  (dt/addDays d n))

(defn diffrence-in-calendar-weeks [^js/Date d1 ^js/Date d2]
  (dt/differenceInCalendarISOWeeks d1 d2))

(defn diffrence-in-weeks [^js/Date d1 ^js/Date d2]
  (dt/differenceInWeeks d1 d2))

(defn end-of-week [^js/Date d]
  (dt/endOfISOWeek d))

(defn week [^js/Date d]
  (dt/getISOWeek d))

(defn week-of-month [^js/Date d]
  (dt/getWeekOfMonth d))

(defn weeks-in-month [^js/Date d]
  (dt/getWeeksInMonth d))

(defn same-week? [^js/Date d1 ^js/Date d2]
  (dt/isSameISOWeek d1 d2))

(defn last-day-of-week [^js/Date d]
  (dt/lastDayOfISOWeek d))

(defn set-week [^js/Date d ^long n]
  (dt/setISOWeek d n))

(defn start-of-week [^js/Date d]
  (dt/startOfISOWeek d))

(defn sub-weeks [^js/Date d ^long n]
  (dt/subWeeks d n))

(defn add-months [^js/Date d ^long n]
  (dt/addMonths d n))

(defn diffrence-in-calendar-months [^js/Date d1 ^js/Date d2]
  (dt/differenceInCalendarMonths d1 d2))

(defn diffrence-in-months [^js/Date d1 ^js/Date d2]
  (dt/differenceInMonths d1 d2))

(defn days-in-month [^js/Date d]
  (dt/getDaysInMonth d))

(defn end-of-month [^js/Date d]
  (dt/endOfMonth d))

(defn month [^js/Date d]
  (dt/getMonth d))

(defn same-month? [^js/Date d1 ^js/Date d2]
  (dt/isSameMonth d1 d2))

(defn last-day-of-month [^js/Date d]
  (dt/lastDayOfMonth d))

(defn last-day-of-month? [^js/Date d]
  (dt/isLastDayOfMonth d))

(defn first-day-of-month? [^js/Date d]
  (dt/isFirstDayOfMonth d))

(defn set-month [^js/Date d ^long n]
  (dt/setMonth d n))

(defn start-of-month [^js/Date d]
  (dt/startOfMonth d))

(defn sub-months [^js/Date d ^long n]
  (dt/subMonths d n))

(defn add-years [^js/Date d ^long n]
  (dt/addYears d n))

(defn diffrence-in-calendar-years [^js/Date d1 ^js/Date d2]
  (dt/differenceInCalendarYears d1 d2))

(defn diffrence-in-years [^js/Date d1 ^js/Date d2]
  (dt/differenceInYears d1 d2))

(defn days-in-year [^js/Date d]
  (dt/getDaysInYear d))

(defn end-of-year [^js/Date d]
  (dt/endOfYear d))

(defn year [^js/Date d]
  (dt/getYear d))

(defn same-year? [^js/Date d1 ^js/Date d2]
  (dt/isSameYear d1 d2))

(defn leap-year? [^js/Date d]
  (dt/isLeapYear d))

(defn set-year [^js/Date d ^long n]
  (dt/setYear d n))

(defn start-of-year [^js/Date d]
  (dt/startOfYear d))

(defn sub-years [^js/Date d ^long n]
  (dt/subYears d n))

(defn add [^js/Date d  ^Keyword period ^long n]
  (case period
    :milliseconds (add-milliseconds d n)
    :ms (add-milliseconds d n)
    :seconds (add-seconds d n)
    :s (add-seconds d n)
    :minutes (add-minutes d n)
    :m (add-minutes d n)
    :hours (add-hours d n)
    :h (add-hours d n)
    :days (add-days d n)
    :d (add-days d n)
    :weaks (add-weeks d n)
    :w (add-weeks d n)
    :months (add-months d n)
    :M (add-months d n)
    :years (add-years d n)
    :y (add-years d n)))

(defn sub [^js/Date d  ^Keyword period ^long n]
  (case period
    :milliseconds (sub-milliseconds d n)
    :ms (sub-milliseconds d n)
    :seconds (sub-seconds d n)
    :s (sub-seconds d n)
    :minutes (sub-minutes d n)
    :m (sub-minutes d n)
    :hours (sub-hours d n)
    :h (sub-hours d n)
    :days (sub-days d n)
    :d (sub-days d n)
    :weaks (sub-weeks d n)
    :w (sub-weeks d n)
    :months (sub-months d n)
    :M (sub-months d n)
    :years (sub-years d n)
    :y (sub-years d n)))

(defn range [^js/Date d1 ^js/Date d2 ^Keyword period]
  {:pre [(valid? d1)
         (valid? d2)
         (before? d1 d2)]}
  (take-while
   #(before? % (add d2 period 1))
   (iterate #(add % period 1) d1)))

(defprotocol Datetime
  (date-time [x]))

(extend-type string
  Datetime
  (date-time [x] (parse-iso x)))

(extend-type number
  Datetime
  (date-time [x] (to-date x)))

(extend-type default
  Datetime
  (date-time [x] (js/Date.)))


