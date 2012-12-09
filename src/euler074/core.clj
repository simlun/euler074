(ns euler074.core)

(defn integer-to-list [integer] 
  (map #(- (int %) (int \0)) (str integer)))

(defn factorial [n]
  (let [r (range 1 (inc n))]
  (if (= n 0)
    1
    (reduce * r))))

(defn sum-of-factorials [integers]
  (reduce + (map factorial integers)))

(defn- linear-contains? [coll target]
  (if (some #{target} coll) true false))

(defn non-repeating-terms [starting-number]
  (defn recursion [mjao]
    (let [next-term  (sum-of-factorials (integer-to-list starting-number))]
    (if (some }
    )
  (recursion (list starting-number)))