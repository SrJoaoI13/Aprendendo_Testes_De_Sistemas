import { useState, useEffect } from 'react'
import axios from 'axios'
import './App.css'

function App() {
  const [n1, setN1] = useState('')
  const [n2, setN2] = useState('')
  const [resultado, setResultado] = useState('Aguardando operação...')
  const [erro, setErro] = useState('')
  const [historico, setHistorico] = useState([])

  const API_URL = '/api/calculadora'

  useEffect(() => {
    carregarHistorico()
  }, [])

  const carregarHistorico = async () => {
    try {
      const response = await axios.get(`${API_URL}/historico`)
      setHistorico(response.data.reverse())
    } catch (error) {
      console.error('Erro ao carregar histórico:', error)
    }
  }

  const calcular = async (operacao) => {
    setResultado('Calculando...')
    setErro('')

    try {
      let url = `${API_URL}/calcular?op=${operacao}`
      if (n1 !== '') url += `&n1=${n1}`
      if (n2 !== '') url += `&n2=${n2}`

      const response = await axios.get(url)
      const data = response.data

      if (data.erro) {
        setResultado('---')
        setErro(data.erro)
      } else {
        setResultado(data.resultado)
        setErro('')
      }
      
      carregarHistorico()
    } catch (error) {
      setResultado('---')
      setErro('Erro ao conectar com o servidor.')
      console.error(error)
    }
  }

  const limparHistorico = async () => {
    if (window.confirm('Deseja realmente excluir todo o histórico?')) {
      try {
        await axios.delete(`${API_URL}/historico`)
        carregarHistorico()
      } catch (error) {
        console.error('Erro ao limpar histórico:', error)
      }
    }
  }

  return (
    <div className="container">
      <h1>Calculadora Web React</h1>
      
      <div className="calculator-form">
        <div className="input-group">
          <label>Primeiro Número:</label>
          <input 
            type="number" 
            value={n1} 
            onChange={(e) => setN1(e.target.value)} 
            placeholder="Digite o primeiro número" 
          />
        </div>
        
        <div className="input-group">
          <label>Segundo Número:</label>
          <input 
            type="number" 
            value={n2} 
            onChange={(e) => setN2(e.target.value)} 
            placeholder="Digite o segundo número" 
          />
        </div>
        
        <div className="buttons">
          <button onClick={() => calcular('soma')}>Soma (+)</button>
          <button onClick={() => calcular('subtracao')}>Subtração (-)</button>
          <button onClick={() => calcular('multiplicacao')}>Multiplicação (*)</button>
          <button onClick={() => calcular('divisao')}>Divisão (/)</button>
          <button onClick={() => calcular('porcentagem')}>Porcentagem (%)</button>
          <button onClick={() => calcular('potenciacao')}>Potenciação (^)</button>
          <button onClick={() => calcular('raiz')}>Raiz Quadrada (√)</button>
        </div>
      </div>

      <div className="result-area">
        <h3>Resultado:</h3>
        <p id="resultado">{resultado}</p>
        {erro && <p className="error-msg">{erro}</p>}
      </div>

      <div className="history-area">
        <div className="history-header">
          <h3>Histórico de Operações</h3>
          <button onClick={limparHistorico} className="btn-clear">Limpar Histórico</button>
        </div>
        <table>
          <thead>
            <tr>
              <th>Data/Hora</th>
              <th>N1</th>
              <th>Op</th>
              <th>N2</th>
              <th>Resultado</th>
              <th>Erro</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            {historico.map((op) => (
              <tr key={op.id}>
                <td>{new Date(op.dataHora).toLocaleString('pt-BR')}</td>
                <td>{op.numero1 ?? '-'}</td>
                <td>{op.operacao}</td>
                <td>{op.numero2 ?? '-'}</td>
                <td>{op.resultado ?? '-'}</td>
                <td>{op.erro ?? '-'}</td>
                <td>
                  <span className={op.erro ? 'status-fail' : 'status-pass'}>
                    {op.erro ? 'Falha' : 'Passou'}
                  </span>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default App
