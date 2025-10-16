(ns atividade)

(defn classificar-nota [nota]
  (cond
    (>= nota 90) "A"
    (>= nota 80) "B"
    (>= nota 70) "C"
    (>= nota 60) "D"
    :else "F"))

(defn main []
  (println "Quantos alunos na turma?")
  (let [qtd (Integer/parseInt (read-line))]
    (loop [i 1
           soma-notas 0
           aprovados 0]
      (if (<= i qtd)
        (do
          (println (str "\nNome do aluno " i ":"))
          (let [nome (read-line)]
            (println "Nota:")
            (let [nota (Integer/parseInt (read-line))
                  conceito (classificar-nota nota)
                  novo-soma (+ soma-notas nota)
                  novo-aprovados (if (>= nota 60) (inc aprovados) aprovados)]
              (println (str nome " - Conceito: " conceito))
              (recur (inc i) novo-soma novo-aprovados))))
        (let [media (/ soma-notas qtd)]
          (println (str "\nMedia da turma: " media))
          (println (str "Aprovados: " aprovados))
          (println "Desempenho geral:"
                   (if (>= media 80)
                     "Turma excelente!"
                     (if (>= media 60)
                       "Bom desempenho!"
                       "e necessario melhorar!"))))))))

(main)
