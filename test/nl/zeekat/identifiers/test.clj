(ns nl.zeekat.identifiers.test
  (:use nl.zeekat.identifiers
        clojure.test))

(deftest java-style
  (is (= (class-name "test-me") "TestMe"))
  (is (= (class-name "test") "Test"))
  (is (= (field-name "test-me") "testMe"))
  (is (= (field-name "test") "test")))

(deftest lisp-style
  (is (= (lisp-name "TestMe") "test-me"))
  (is (= (lisp-name "testMe") "test-me"))
  (is (= (lisp-name "test") "test")))

