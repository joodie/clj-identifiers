(ns nl.zeekat.identifiers
  (:require [clojure.string :refer [split]]))

(defn- upcase-char
  [c]
  #?(:clj (Character/toUpperCase c)
     :cljs (.toUpperCase c)))

(defn- downcase-char
  [c]
  #?(:clj (Character/toLowerCase c)
     :cljs (.toLowerCase c)))

(defn- char-upper-case?
  [c]
  #?(:clj (Character/isUpperCase c)
     :cljs (= (.toUpperCase c) c)))

(defn- upcase-first
  "uppercase the first letter of the string"
  [^String s]
  (apply str (upcase-char (first s)) (rest s)))

(defn field-name
  "convert a dashed-name to a camelCaseName"
  [^String name]
  (let [[first-word & other-words] (split name #"-")] 
    (apply str first-word
           (map upcase-first other-words))))

(defn class-name
  "convert a dashed-name to a CamelCaseName"
  [^String name]
  (apply str (map upcase-first (split name #"-"))))

(defn lisp-name
  "convert a camelCaseName to a dashed-name"
  [^String name]
  (apply str (downcase-char (first name))
         (mapcat #(if (char-upper-case? %)
                    ["-" (downcase-char %)]
                    [%]) (rest name))))
