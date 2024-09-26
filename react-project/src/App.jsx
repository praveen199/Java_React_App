import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import HelloWord from './HelloWorld'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <HelloWord/>
      <button type="button" class="btn btn-primary" >Primary</button>

    </>
  )
}

export default App
