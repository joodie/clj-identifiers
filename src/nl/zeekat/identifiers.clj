(ns nl.zeekat.identifiers
  (:require [clojure.contrib.string :as string]))

(defn- upcase-first
  "uppercase the first letter of the string"
  [^String s]
  (apply str (Character/toUpperCase (first s)) (rest s)))

(defn field-name
  "convert a dashed-name to a camelCaseName"
  [^String name]
  (let [[first-word & other-words] (string/split #"-" name)] 
    (apply str first-word
           (map upcase-first other-words))))

(defn class-name
  "convert a dashed-name to a CamelCaseName"
  [^String name]
  (apply str (map upcase-first (string/split #"-" name))))

(defn lisp-name
  "convert a camelCaseName to a dashed-name"
  [^String name]
  (apply str (Character/toLowerCase (first name))
         (mapcat #(if (Character/isUpperCase %)
                        ["-" (Character/toLowerCase %)]
                        [%]) (rest name))))
