import { Input } from "@/components/ui/input";
import { Search } from "lucide-react";

export function PageSearch() {
    return (
        <div className="flex w-full items-center py-4">
            <Search className="text-muted-foreground relative left-10 top-3 transform -translate-y-1/2" />
            <Input
                placeholder="Busque alguém para seguir..."
                className="pl-12 rounded-full font-light text-lg"
            />
        </div>
    );
}
