(ns euler074.core
  (:gen-class))

(defn integer-to-list [integer]
  (map #(- (int %) (int \0)) (str integer)))

(defn factorial [n]
  (let [r (range 1 (inc n))]
  (if (= n 0)
    1
    (reduce * r))))

(def factorial-memo (memoize factorial))

(defn sum-of-factorials [integers]
  (reduce + (map factorial integers)))

(defn non-repeating-terms [starting-number]
  (loop [chain #{starting-number}
         previous-term starting-number]
    (let [next-term (sum-of-factorials (integer-to-list previous-term))]
      (if (contains? chain next-term)
        chain
        (recur (conj chain next-term) next-term)))))

(defn euler074
  ([] (euler074 1000000 60))
  ([up-to n]
    (count (filter #(= n (count %)) (map non-repeating-terms (range 1 (inc up-to)))))))

(defn -main [& args]
  (if (= 2 (count args))
    (let [up-to (read-string (nth args 0))
          n (read-string (nth args 1))]
      (println (euler074 up-to n)))
    (println (euler074))))

