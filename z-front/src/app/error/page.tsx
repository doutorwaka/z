import { Button } from "@/components/ui/button";
import Link from "next/link";

export default function ErrorPage(){
    return (
        <div className="relative flex justify-center items-center pb-96 w-[1200px] m-auto h-[100vh]">
            <div className="flex flex-col w-full bg-zinc-900 max-w-[680px] justify-center border-muted-foreground border-2 rounded-xl p-8">
                <span className="p-8 text-xl font-bold m-auto">
                    Ops, algo deu errado!
                </span>
                <span className="text-muted-foreground m-auto">
                    {"Por favor, tente novamente mais tarde!"}
                </span>

                <Button asChild className="max-w-md m-auto my-8">
                    <Link href="/">Voltar</Link>
                </Button>
            </div>
        </div>
    )
}