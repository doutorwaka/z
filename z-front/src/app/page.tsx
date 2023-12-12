import { CreateAccount } from '@/components/create-account'
import Image from 'next/image'

export default function Home() {
  return (
    <main className="grid grid-cols-1 max-w-[500px] m-auto py-20">
      <CreateAccount/>
    </main>
  )
}
