(ns euler074.core
  (:gen-class))

(defn integer-to-list [integer]
  (let [char-to-int #(- (int %) (int \0))]
    (map char-to-int (str integer))))

(defn factorial [n]
  (let [r (range 1 (inc n))]
  (if (= n 0)
    1
    (reduce * r))))

(defn sum-of-factorials [integers]
  (def factorial-memo (memoize factorial))
  (reduce + (map factorial-memo integers)))

(defn non-repeating-terms [starting-number]
  (loop [chain #{starting-number}
         previous-term starting-number]
    (let [next-term (sum-of-factorials (integer-to-list previous-term))]
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

