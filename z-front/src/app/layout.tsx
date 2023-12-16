import type { Metadata } from "next";
import { Roboto } from "next/font/google";
import "./globals.css";
import { cn } from "@/utils/utils";
import { ThemeProvider } from "@/providers/theme-provider";
import { NextAuthProvider } from "@/providers/next-auth-provider";

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
            <body
                className={cn(
                    "min-h-screen bg-background font-roboto antialiased",
                    roboto.className
                )}
            >
                <ThemeProvider
                    attribute="class"
                    defaultTheme="dark"
                    enableSystem
                    disableTransitionOnChange
                >
                    <NextAuthProvider>{children}</NextAuthProvider>
                </ThemeProvider>
            </body>
        </html>
    );
}
