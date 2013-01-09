(ns euler074.core
  (:gen-class))

(defn integer-to-list [integer]
  (loop [integer-to-explode integer
         digits ()]
    (let [next-integer-to-explode (unchecked-divide-int integer-to-explode 10)
          next-digits (conj digits (unchecked-remainder-int integer-to-explode 10))]
      (if (= next-integer-to-explode 0)
        next-digits
        (recur next-integer-to-explode next-digits)))))

(defn factorial [n]
  (let [r (range 1 (inc n))]
  (if (= n 0)
    1
    (reduce * r))))

(defn sum-of-factorials [integers]
  (reduce + (map factorial integers)))

(def sum-of-factorials-memo (memoize sum-of-factorials))

(defn non-repeating-terms [starting-number]
  (loop [chain #{starting-number}
         previous-term starting-number]
    (let [sorted-previous-term-integers (sort (integer-to-list previous-term))
          next-term (sum-of-factorials-memo sorted-previous-term-integers)]
      (if (contains? chain next-term)
        chain
        (recur (conj chain next-term) next-term)))))

(defn euler074
  ([] (euler074 1000000 60))
  ([up-to chain-length]
    (let [right-chain-length? #(= chain-length (count %))
          starting-numbers (range 1 (inc up-to))]
      (count (filter right-chain-length? (map non-repeating-terms starting-numbers))))))

(defn -main [& args]
  (println 
    (if (= 2 (count args))
      (let [up-to (read-string (nth args 0))
            chain-length (read-string (nth args 1))]
        (euler074 up-to chain-length))
      (euler074))))

