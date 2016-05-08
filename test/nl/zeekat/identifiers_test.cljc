(ns nl.zeekat.identifiers-test
  (:require [nl.zeekat.identifiers :refer [class-name field-name lisp-name]]
            #?(:cljs [cljs.test :refer-macros [deftest is]]
               :clj [clojure.test :refer [deftest is]])))

(deftest java-style
  (is (= (class-name "test-me") "TestMe"))
  (is (= (class-name "test") "Test"))
  (is (= (field-name "test-me") "testMe"))
  (is (= (field-name "test") "test")))

(deftest lisp-style
  (is (= (lisp-name "TestMe") "test-me"))
  (is (= (lisp-name "testMe") "test-me"))
  (is (= (lisp-name "test") "test")))

