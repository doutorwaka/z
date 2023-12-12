import type { Metadata } from "next";
import { Roboto } from "next/font/google";
import "./globals.css";

export const metadata: Metadata = {
    title: "Z :: Sua plataforma social!",
    description:
        "Plataforma social criada como projeto da masterclass do Doutorwaka.com",
};

const roboto = Roboto({
    weight: ["100", "400", "700"],
    subsets: ["latin"],
    variable: "--font-roboto",
});

export default function RootLayout({
    children,
}: {
    children: React.ReactNode;
}) {
    return (
        <html lang="pt-BR">
            <body className={roboto.variable}>{children}</body>
        </html>
    );
}
