import type { Metadata } from 'next'
import './globals.css'

export const metadata: Metadata = {
  title: 'Z :: Sua plataforma social!',
  description: 'Plataforma social criada como projeto da masterclass do Doutorwaka.com',
}

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <html lang="pt-BR">
      <body>{children}</body>
    </html>
  )
}
